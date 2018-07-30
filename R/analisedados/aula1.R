install.packages("plyr")

library(plyr)

options(max.print = 50000)

aulas[33137, 3] <- 3255

sort(aulas$section_id)

unique(aulas$section_id)

length(unique(aulas$section_id))

sort(table(aulas$section_id))

sort(table(aulas$course_id))

auxiliar <- count(aulas, vars = "course_id")

write.csv(auxiliar, "/home/leandro/GitHub/ordnaelmedeiros/alura/R/analisedados/popularidade.csv")

rm(list=ls())
