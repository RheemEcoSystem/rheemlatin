package org.qcri.rheem.latin.util;

import org.qcri.rheem.latin.exception.ResourceNotFoundException;

import java.io.*;
import java.util.Properties;

/**
 * Created by bertty on 08-03-17.
 */
public class FileLocalizer {
    static File localTempDir = new File("tmp");

    public static class FetchFileRet {
        public FetchFileRet(File file, boolean didFetch) {
            this.file = file;
            this.didFetch = didFetch;
        }
        public File file;
        public boolean didFetch;
    }

    /**
     * Ensures that the passed path is on the local file system, fetching it
     * to the java.io.tmpdir if necessary. If pig.jars.relative.to.dfs is true
     * and dfs is not null, then a relative path is assumed to be relative to the passed
     * dfs active directory. Else they are assumed to be relative to the local working
     * directory.
     */
    public static FetchFileRet fetchFile(Properties properties, String filePath) throws IOException {
        return fetchFilesInternal(properties, filePath, false)[0];
    }

    /**
     * Ensures that the passed files pointed to by path are on the local file system,
     * fetching them to the java.io.tmpdir if necessary. If pig.jars.relative.to.dfs is true
     * and dfs is not null, then a relative path is assumed to be relative to the passed
     * dfs active directory. Else they are assumed to be relative to the local working
     * directory.
     */
    public static FetchFileRet[] fetchFiles(Properties properties, String filePath) throws IOException {
        return fetchFilesInternal(properties, filePath, true);
    }

    public static FetchFileRet[] fetchFilesInternal(Properties properties, String filePath, boolean multipleFile) throws IOException{
        File file = new File(filePath);

        FetchFileRet[] vec_file = null;
        if(file.isFile()){
            vec_file = new FetchFileRet[1];
            vec_file[0].file     = file;
            vec_file[0].didFetch = false;
            return vec_file;
        }
        throw new IOException("No exist file in path");
    }

    /**
     * Ensures that the passed resource is available from the local file system, fetching
     * it to a temporary directory.
     *
     * @throws ResourceNotFoundException
     */
    public static FetchFileRet fetchResource(String name) throws IOException, ResourceNotFoundException {
        FetchFileRet localFileRet = null;
        InputStream resourceStream = LatinContext.getClassLoader().getResourceAsStream(name);
        if (resourceStream != null) {
            File dest = new File(localTempDir, name);
            dest.getParentFile().mkdirs();
            dest.deleteOnExit();

            OutputStream outputStream = null;
            try {
                outputStream = new BufferedOutputStream(new FileOutputStream(dest));
                byte[] buffer = new byte[1024];
                int len;
                while ((len=resourceStream.read(buffer)) > 0) {
                    outputStream.write(buffer,0,len);
                }
            } finally {
                resourceStream.close();
                if (outputStream != null) {
                    outputStream.close();
                }
            }
            localFileRet = new FetchFileRet(dest,false);
        }
        else
        {
            throw new ResourceNotFoundException(name);
        }

        return localFileRet;
    }
}
