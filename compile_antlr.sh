#!/usr/bin/env bash


#java -cp lib/antlr-3.jar org.antlr.Tool  src/main/java/org/qcri/rheem/latin/parser/antlr/QueryLexer.g
#java -cp lib/antlr-3.jar org.antlr.Tool  src/main/java/org/qcri/rheem/latin/parser/antlr/QueryParser.g
#java -cp lib/antlr-3.jar org.antlr.Tool  src/main/java/org/qcri/rheem/latin/parser/antlr/AstValidator.g
#java -cp lib/antlr-3.jar org.antlr.Tool  src/main/java/org/qcri/rheem/latin/parser/antlr/AliasMasker.g
java -cp lib/antlr-3.jar org.antlr.Tool  src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g
#java -cp lib/antlr-3.jar org.antlr.Tool  src/main/java/org/qcri/rheem/parser/antlr/XXXXX.g src/main/java/org/qcri/rheem/parser/XXXXX.g