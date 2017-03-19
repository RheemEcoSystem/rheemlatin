lines = LOAD '/testFilter' as (Col1:INT);
number = FILTER lines BY Col1 > 3;
sort = ORDER number BY Col1;
STORE sort INTO 'salida';