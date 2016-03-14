/**

 /$ regex begin
 [ begin of one of specified caracters - like w[io]n will take win or won
 \[ looking for [ ... used scape bcz [ is special char
 \] same as above
 /$ end
 
**/   
 
println "[1,2,3]".replaceAll(($/[\[\]]/$),"").split(',').collect { it as Integer}