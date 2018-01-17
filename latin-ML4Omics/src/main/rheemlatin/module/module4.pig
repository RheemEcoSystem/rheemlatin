IMPORT 'file:///' AS module;


glioma = LOAD 'file:///module0_0.csv' KEY('drug_id');

glioma_mut = LOAD 'file:///module1_2.csv';


expr_t = LOAD 'file:///module2_3.csv';
expr_t_short = LOAD 'file:///module2_4.csv';

cnv_hi = LOAD 'file:///module3_5.csv';
cnv_low= LOAD 'file:///module3_6.csv';

/**DCAST START*/
glioma_grp = GROUP_BY glioma -> module.getKeyGlioma();

glioma_uni = DISTINCT glioma;

glioma_drugs = MAP glioma_grp -> module.dcast() WITH BROADCAST glioma_uni;

/**DCAST END*/

list_w_join = JOIN cnv_hi_mut_short -> {cnv_hi_mut_short.id_sample}, glioma_drugs -> {glioma_drugs.cosmic_id};

list = MAP list_w_join -> module.getIdSample();

/** sort and save drug ic50s */
drug_ic50s = JOIN glioma_drugs -> {glioma_drugs.cosmic_id}, list;

STORE drug_ic50s 'file:///gdsc_ic50.csv';


/** sort and save CNV+Mut data */
cnv_hi_mut_short = JOIN cnv_hi -> {cnv_hi.id_sample },glioma_mut -> {glioma_mut.cln};

cnv_low_mut_short = JOIN cnv_low -> {cnv_low.id_sample },glioma_mut -> {glioma_mut.cln};


cnv_hi_mut_short_out = JOIN cnv_hi_mut_short -> {cnv_hi_mut_short.id_sample}, list;
STORE cnv_hi_mut_short_out 'file:///gdsc_mut+cnv_hi.csv';

cnv_low_mut_short_out = JOIN cnv_low_mut_short -> {cnv_low_mut_short.id_sample}, list;
STORE cnv_low_mut_short_out 'file:///gdsc_mut+cnv_low.csv';


/** sort and save CNV+MUT+EXP short data */

cnv_hi_mut_short_expr_short = JOIN cnv_hi_mut_short -> {cnv_hi_mut_short.id_sample}, expr_t_short -> {expr_t_short.cosmic_id};

cnv_hi_mut_short_expr_short_out = JOIN cnv_hi_mut_short_expr_short -> {cnv_hi_mut_short_expr_short.id_sample}, list;
STORE cnv_hi_mut_short_expr_short_out 'file:///gdsc_mut+cnv+exp_hi.csv';

cnv_low_mut_short_expr_short = JOIN cnv_low_mut_short -> {cnv_low_mut_short.id_sample}, expr_t_short -> {expr_t_short.cosmic_id};

cnv_low_mut_short_expr_short_out = JOIN cnv_low_mut_short_expr_short -> {cnv_low_mut_short_expr_short.id_sample}, list;
STORE cnv_low_mut_short_expr_short_out 'file:///gdsc_mut+cnv+exp_low.csv';

/** sort and save CNV+MUT+EXP data */

cnv_hi_mut_short_expr_t = JOIN cnv_hi_mut_short -> {cnv_hi_mut_short.id_sample}, expr_t -> {expr_t.cosmic_id};

cnv_hi_mut_short_expr_t_out = JOIN cnv_hi_mut_short_expr_t -> {cnv_hi_mut_short_expr_t.id_sample}, list;
STORE cnv_hi_mut_short_expr_out 'file:///gdsc_mut+cnv+exp_full_hi.csv';


cnv_low_mut_short_expr_t = JOIN cnv_low_mut_short -> {cnv_low_mut_short.id_sample}, expr_t -> {expr_t.cosmic_id};

cnv_low_mut_short_expr_t_out = JOIN cnv_low_mut_short_expr_t -> {cnv_low_mut_short_expr_t.id_sample}, list;
STORE cnv_low_mut_short_expr_t_out 'file:///gdsc_mut+cnv+exp_full_low.csv';
