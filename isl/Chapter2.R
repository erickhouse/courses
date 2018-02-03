college <- read.csv("College.csv")

rownames(college) <- college[,1]
fix(college)

college <- college[,-1]
fix(college)

#really cool remeber this
pairs(college[,1:10])

plot(college)

Elite <- rep("No",nrow(college))
Elite[college$Top10perc >50]="Yes"
Elite <- as.factor(Elite)
college <-data.frame(
  college ,
  Elite)

attach(college)
plot(Outstate, Elite)

hist(Grad.Rate)
