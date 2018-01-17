IMPORT 'file:///' AS module;

cell_lines = LOAD 'file:///gdsc_cell_lines.csv' AS ('', '') ;

drugs_name = LOAD 'file:///drug.names_after_modified_ids.csv' AS ();

drugs = LOAD 'file:///dv17_fitted_dose_response_after_modified_ids.csv' AS ();


first_join = JOIN drugs -> {drugs.}, cell_lines -> {cell_lines.};

second_join  = JOIN first_join -> {first_join.}, drugs_name -> {drugs_name.};

gdsc_glioma = MAP second_join -> module.expPlusColumn();

STORE gdsc_glioma 'file:///module0_0.csv';