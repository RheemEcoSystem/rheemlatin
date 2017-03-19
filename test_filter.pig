lines = LOAD '/testFilter' as (Col1:INT);
number = FILTER lines BY Col1 > 3;
STORE number INTO 'salida';