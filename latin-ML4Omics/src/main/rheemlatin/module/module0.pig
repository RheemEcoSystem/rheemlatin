IMPORT 'file:///ml4omics/udf/Module0.class' AS module;

cell_lines = LOAD 'file:///ml4omics/module0/gdsc_cell_lines.csv' AS ('', '') ;

drugs_name = LOAD 'file:///ml4omics/module0/drug.names_after_modified_ids.csv' AS ();

drugs = LOAD 'file:///ml4omics/module0/dv17_fitted_dose_response_after_modified_ids.csv' AS ();


first_join = JOIN drugs -> {drugs.}, cell_lines -> {cell_lines.};

second_join  = JOIN first_join -> {first_join.}, drugs_name -> {drugs_name.};

gdsc_glioma = MAP second_join -> module.expPlusColumn();

STORE gdsc_glioma 'file:///ml4omics/module0/module0_0.csv';