IMPORT 'file:///' AS module;

gene_list = LOAD 'file:///output1_1.csv';

gdscCnv = LOAD 'file:///Gene_level_CN.csv';


gdscCnv_gene_w_null = MAP  gdscCnv -> module.getGeneName() WITH BROADCAST gene_list;

gdscCnv_gene = FILTER gdscCnv_gene_w_null -> module.removeNull;

gdscCnv_map = MAP gdscCnv_gene -> module.firstMap();

gdscCnv_t = TRANSPOSE gdscCnv_map;


gdscCnv_hi = MAP gdscCnv_t -> module.getHiValue();
gdscCnv_low = MAP gdscCnv_t -> module.getLowValue();

STORE gdscCnv_hi 'file:///module3_5.csv';
STORE gdscCnv_low 'file:///module3_6.csv';

