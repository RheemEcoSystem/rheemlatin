IMPORT 'file:///ml4omics/udf/Module3.class' AS module;
IMPORT 'file:///ml4omics/udf/MapLikeFilterBroadcast.class' AS mapFilter;

gene_list = LOAD 'file:///ml4omics/module1/output1_1.csv';

gdscCnv = LOAD 'file:///ml4omics/module3/Gene_level_CN.csv'
                AS('gene_name','chr','start','stop')
                DELIMITER '\"[^"]*"|[^,]*';


gdscCnv_gene_w_null = MAP  gdscCnv -> module.getGeneName() WITH BROADCAST gene_list;

gdscCnv_gene = FILTER gdscCnv_gene_w_null -> module.removeNull();

gdscCnv_map = MAP gdscCnv_gene -> module.firstMap();

gdscCnv_t = TRANSPOSE gdscCnv_map;


gdscCnv_hi = MAP gdscCnv_t -> module.getHiValue();
gdscCnv_low = MAP gdscCnv_t -> module.getLowValue();

STORE gdscCnv_hi 'file:///ml4omics/module3/module3_5.csv';
STORE gdscCnv_low 'file:///ml4omics/module3/module3_6.csv';

