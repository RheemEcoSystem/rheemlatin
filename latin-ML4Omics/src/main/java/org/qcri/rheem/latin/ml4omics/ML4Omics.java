package org.qcri.rheem.latin.ml4omics;

import org.qcri.rheem.basic.data.Tuple2;
import org.qcri.rheem.core.function.FunctionDescriptor;
import org.qcri.rheem.latin.core.plan.structure.bag.HeaderBag;
import org.qcri.rheem.latin.core.plan.structure.bag.RecordBag;

public class ML4Omics {


    public static FunctionDescriptor.SerializableFunction<Tuple2<RecordBag, RecordBag>, RecordBag> proyection(){
        final HeaderBag header_new = new HeaderBag( "cell_line_name",
                                                    "cosmic_id",
                                                    "histology",
                                                    "tissue",
                                                    "drug_name",
                                                    "drug_id",
                                                    "ln_ic50",
                                                    "auc");
        return tuple -> {






            return new RecordBag(header_new, null);
        };
    }

    public static FunctionDescriptor.SerializableFunction<Tuple2<RecordBag, RecordBag>, RecordBag> firstjoin(){
        final HeaderBag header_new = new HeaderBag( "cell_line_name",
                                                    "cosmic_id",
                                                    "tissue",
                                                    "Histology",
                                                    "drug_name",
                                                    "drug_id");


       // 'dataset_version','ic50_results_id','cosmic_id,drug_id','max_conc_micromolar','ln_ic50','auc','rmse'
        return tuple -> {
            Object[] _tmp = new Object[6];
            return new RecordBag(header_new, null);
        };
    }
}
