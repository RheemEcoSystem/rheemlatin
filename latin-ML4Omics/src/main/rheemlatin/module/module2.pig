IMPORT 'file:///' AS module;


gdsc_glioma = LOAD 'file:///module0_0'
                    AS (
                        'cell_line_name',
                        'cosmic_id',
                        'histology',
                        'tissue',
                        'drug_name',
                        'drug_id',
                        'ln_ic50',
                        'auc',
                        'ic_50_uM'
                    )
                    KEY('cosmic_id', 'cell_line_name');

gene_list = LOAD 'file:///output1_1.csv';

file_expr = LOAD 'file:///CCLE_Expression_Entrez_2012-10-18.csv';

expr_w_null = MAP file_expr -> module.loadRecord();

expr = FILTER expr_w_null -> module.filterNull();

expr_t = TRANSPOSE expr;

cell_line_uni = DISTINCT gdsc_glioma;

cell_line_end = MAP cell_line_uni -> module.gsubAndToupper();

expr_t_join = JOIN cell_line_end -> cell_line.cell_line_name, expr_t -> { expr_t.cell_line };

STORE expr_t_join 'file:///module2_3';


expr_t_short = MAP expr_t_join -> module.getGeneName WITH BROADCAST gene_list;


STORE expr_t_join_short 'file:///module2_4';

