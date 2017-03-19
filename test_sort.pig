lines = LOAD '/testFilter' as (Col1:INT);
number = ORDER lines by Col1;
STORE number INTO 'salida';