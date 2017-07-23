# Functional Program Design in Scala Notes

## Week 1

 - Arrays, Seqs, and Map are actually functions. They themselves are traits that extend the function class

 - There is a special sub type of function called a partialFunction.

 - You can check if there is a pattern match implementation by checking ` myfun.isDefinedAt("CaseName") `. isDefinedAt does not guarentee the removal pattern matching erros. It only checks the outer most match case. It does not check nested matches.

 - for expression can easily be composed to create database like queries with implicit pattern matching and filters