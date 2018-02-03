
klout <- read.csv("klout_scores.csv")

kdata <- klout[,1]
m <- mean(kdata)
std.dev <- sd(kdata)

#std error is the standard deviation devided by the square root length of the sample size
std.error <- function(data.set, sample.size) sd(data.set)/sqrt(sample.size)
std.error2 <- function(x) sd(x)/sqrt(length(x))

std.error(kdata, 250)

#z score of 40 is the population mean / the std dev of the population mean
z.score <- (40 - mean(kdata)) / std.error(kdata, 250)

probability.of.40.in.our.sample.mean <- 1- pnorm(z.score)

#little project at the end

#pick a random value from the data
value <- kdata[50]
random.numbers.in.set <- as.integer(runif(5, 1, 1048))
mean.of.random.num <- mean(kdata[random.numbers.in.set])

random.numbers.in.set.2 <- as.integer(runif(10, 1, 1048))
mean.of.random.num.2 <- mean(kdata[random.numbers.in.set.2])

set.seed(10)
x <- as.integer(runif(10, 1, 10))
y <- as.integer(runif(10, 1, 10))


test <- function(x, y) {
  
  output <- vector()

  for (i in length(x)) {
    output[i] <- x[i] + y[i]
    
  } 
  return(output)
}

result <- test(x, y)



