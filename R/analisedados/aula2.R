library(plyr)

duracao = read.csv(file="/home/leandro/GitHub/ordnaelmedeiros/alura/R/analisedados/duracao.csv", header=TRUE, sep=",")

duracao <- rename(duracao, replace = c("user_id"="aluno", "course_id"="curso", "timeToFinish"="dias"))

plot(duracao$dias)

hist(duracao$dias)

hist(duracao$dias, breaks = 3)

hist(duracao$dias, breaks = 20)

hist(
  duracao$dias,
  breaks = 20,
  main = "Histograma do Tempo",
  ylab = "Quantidade",
  xlab = "Tempo",
  ylim = c(0, 2000),
  xlim = c(0, 600),
  col = "blue"
)

jpeg("/home/leandro/GitHub/ordnaelmedeiros/alura/R/analisedados/duracao.jpg")
hist(
  duracao$dias,
  breaks = 20,
  main = "Histograma do Tempo",
  ylab = "Quantidade",
  xlab = "Tempo",
  ylim = c(0, 2000),
  xlim = c(0, 600),
  col = "blue"
)
dev.off()

mean(duracao$dias, na.rm = T)

median(duracao$dias, na.rm = T)

summary(duracao$dias)["NA's"]/dim(duracao)[1]*100

length(unique(duracao$curso))
length(unique(duracao$aluno))


summary(duracao)
