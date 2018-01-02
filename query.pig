IMPORT 'file:///Users/bertty/Qatar/external/target/classes/org/qcri/external/MyImport.class' AS myclass;


/*file = LOAD 'file:///Users/bertty/latin/number.txt';
file_broad = LOAD 'file:///Users/bertty/latin/broadcast.txt';

broad = MAP file_broad -> myclass.getConvert();

map_op = MAP file -> myclass.getBroadcast() WITH BROADCAST broad;

STORE map_op 'file:///Users/bertty/latin/result.txt';

*

file = LOAD 'file:///Users/bertty/latin/number.txt'

map_op = MAP file -> myclass.getBroadcast() ;
STORE map_op 'file:///Users/bertty/latin/result.txt';
*/
bag1_file = LOAD 'file:///Users/bertty/latin/bag1.txt';
//bag2_file = LOAD 'file:///Users/bertty/latin/bag2.txt';
//bag3_file = LOAD 'file:///Users/bertty/latin/bag3.txt';



mybag1 = BAG() <- bag1_file;

STORE mybag1 'file:///Users/bertty/latin/result.txt';

/*
mybag1 = BAG () <- file;
mybag2 = BAG (['col1', 'col2']) <- second;
mybag3 = BAG (['col1', 'col2'], withHeader=TRUE, regex=';') <- file;
mybag4 = BAG (withHeader=TRUE) <- second;
mybag5 = BAG (regex=';') <- file;
mybag6 = BAG (withHeader=TRUE, regex=';') <- second;

mybag1.withHeader <- TRUE;
mybag1.regex <- ';';
mybag1.header <- ['col1'];
mybag4.header <- ['col1':INT, 'col2':LONG];
*/


