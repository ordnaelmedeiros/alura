install.packages('ggplot2')


library(plyr)
library(readxl)
library(ggplot2)

duracao = read.csv(file="/home/leandro/GitHub/ordnaelmedeiros/alura/R/analisedados/duracao.csv", header=TRUE, sep=",")
cursos = read.csv(file="/home/leandro/GitHub/ordnaelmedeiros/alura/R/analisedados/cursos.csv", header=TRUE, sep=",")
popularidade = read.csv(file="/home/leandro/GitHub/ordnaelmedeiros/alura/R/analisedados/popularidade.csv", header=TRUE, sep=",")

duracao <- rename(duracao, replace = c("user_id"="aluno", "course_id"="curso", "timeToFinish"="dias"))


sumarioEstatistico <- aggregate(
  duracao$dias,
  list(duracao$curso),
  mean,
  na.rm = T
)

sumarioEstatistico <- rename(sumarioEstatistico, replace = c("Group.1"="curso", "x"="dias"))

popularidade <- rename(popularidade, replace = c("course_id"="curso", "freq"="popularidade"))


popularidadeComDuracao <- merge(
  sumarioEstatistico,
  popularidade,
  by = "curso"
)


####  aula 5

plot(popularidadeComDuracao$dias, popularidadeComDuracao$popularidade)

modelo.linear <- lm(popularidadeComDuracao$popularidade ~ popularidadeComDuracao$dias)

abline(modelo.linear)

scatter.smooth(
  popularidadeComDuracao$dias,
  popularidadeComDuracao$popularidade,
  pch=21,
  col='red'
)


grafico <- ggplot(
  popularidadeComDuracao,
  aes(dias, popularidade)
)

grafico = grafico + geom_point()

grafico = grafico + geom_smooth()

grafico











