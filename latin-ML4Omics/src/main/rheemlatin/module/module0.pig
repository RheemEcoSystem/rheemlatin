IMPORT 'file:///ml4omics/udf/Module0.class' AS module;

cell_lines = LOAD 'file:///ml4omics/module0/gdsc_cell_lines.csv'
                   AS ('cell_line_name',
                       'cosmic_id',
                       'tissue',
                       'histology')
                   DELIMITER ',';

drugs_name = LOAD 'file:///ml4omics/module0/drug.names_after_modified_ids.csv'
                   AS ('drug_name',
                       'drug_id')
                   DELIMITER ',';

drugs = LOAD 'file:///ml4omics/module0/dv17_fitted_dose_response_after_modified_ids.csv'
              AS ('dataset_version',
                  'ic50_results_id',
                  'cosmic_id',
                  'drug_id',
                  'max_conc_micromolar',
                  'ln_ic50',
                  'auc',
                  'rmse')
              DELIMITER ',';


first_join = JOIN drugs -> {drugs.cosmic_id}, cell_lines -> {cell_lines.cosmic_id};

second_join  = JOIN first_join -> {first_join.drug_id}, drugs_name -> {drugs_name.drug_id};

gdsc_glioma = MAP second_join -> module.expPlusColumn();

STORE gdsc_glioma 'file:///ml4omics/module0/module0_0.csv';