package org.qcri.rheem.latin.ml4omics.module;

import com.google.common.collect.Streams;
import org.qcri.rheem.basic.data.Record;
import org.qcri.rheem.core.function.FunctionDescriptor;
import org.qcri.rheem.latin.core.plan.structure.bag.HeaderBag;
import org.qcri.rheem.latin.core.plan.structure.bag.RecordBag;
import org.qcri.rheem.latin.udf.broadcast.FunctionBroadcast;

import java.util.Iterator;

public class Module1 {

    public static FunctionDescriptor.SerializableFunction<RecordBag, RecordBag> firstMap() {
        String column = "gene_name";
        return (recordBag) -> {
            String value = recordBag.getValue("gene_name");
            String[] tmp = value.split("_");
            recordBag.setValue("gene_name", tmp[0]);
            return recordBag;
        };
    }

    public static FunctionDescriptor.SerializableFunction<RecordBag, RecordBag> secondMap() {
        String column = "mutation_grch37_genome_position";
        String[] names = new String[0];
        HeaderBag new_header = new HeaderBag(new String[]{"gene_name", "accession_number", "gene_cds_length", "hgnc_id", "sample_name", "id_sample", "id_tumour", "primary_site", "site_subtype", "orimary_histology", "histology_subtype", "genome-wide_screen", "mutation_id", "mutation_cds", "mutation_aa", "mutation_description", "mutation_zygosity", "mutation_grch37_genome_position", "mutation_grch37_strand", "snp", "fathm_prediction", "mutation_somatic_status", "pubmed_pmid", "id_study", "institute", "institute_address", "catalogue_number", "sample_source", "tumour_origin", "age", "comments", "cell_line_name", "cosmic_id", "histology", "tissue", "drug_name", "drug_id", "ln_ic50", "auc", "ic_50_uM", "chr", "start", "stop"});
        return (recordBag) -> {
            String genome = recordBag.getValue("mutation_grch37_genome_position");
            String[] first = genome.split(":");
            String[] second = first[1].split("-");
            Object[] elements = new Object[]{first[0], second[0], second[1]};
            recordBag.append(elements);
            recordBag.setHeader(new_header);
            return recordBag;
        };
    }

    public static FunctionDescriptor.SerializableFunction<Iterable<RecordBag>, RecordBag> getFrecuency() {
        HeaderBag header = new HeaderBag(new String[]{"frecuency", "list"});
        header.setKeys(new String[]{"frecuency"});
        return (list) -> {
            Object[] record = new Object[]{Streams.stream(list).count() * -1L, list};
            return new RecordBag(header, new Record(record));
        };
    }

    public static FunctionDescriptor.SerializableFunction<RecordBag, String> getGene_name() {
        new HeaderBag(new String[]{"frecuency", "name"});
        return (recordBag) -> {
            int position = recordBag.getHeader().position("list");
            Iterable<RecordBag> list = (Iterable)recordBag.getRecord().getField(position);
            Iterator<RecordBag> iterator = list.iterator();
            if (iterator.hasNext()) {
                RecordBag bag = (RecordBag)iterator.next();
                return bag.getValue("gene_name");
            } else {
                return null;
            }
        };
    }

    public static FunctionDescriptor.SerializablePredicate<RecordBag> filterTopK() {
        return new LimitFilter(1000);
    }

    public static FunctionDescriptor.SerializableFunction<RecordBag, Iterable<RecordBag>> flatMap() {
        String[] keys = new String[]{"gene_name"};
        return (recordBag) -> {
            int position = recordBag.getHeader().position("list");
            Iterable<RecordBag> iterable = (Iterable)recordBag.getRecord().getField(position);
            RecordBag record = (RecordBag)iterable.iterator().next();
            if (record != null) {
                record.getHeader().setKeys(keys);
            }

            return iterable;
        };
    }

    public static FunctionDescriptor.SerializableFunction<RecordBag, RecordBag> getKeyGlioma() {
        String[] names = new String[]{"sample_name", "id_sample"};
        HeaderBag header = new HeaderBag(names);
        return (recordBag) -> {
            Object[] obj = new Object[names.length];

            for(int i = 0; i < names.length; ++i) {
                obj[i] = recordBag.getValue(names[i]);
            }

            return new RecordBag(header, new Record(obj));
        };
    }

    public static FunctionBroadcast<Iterable<RecordBag>, RecordBag, RecordBag> dcast() {
        String[] names = new String[]{"sample_name", "id_sample"};
        return new MapBroadcast("gene_name", "auc", names);
    }
}
