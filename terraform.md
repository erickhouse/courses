### Core concepts

It's basically just a JSON language extension and a libarary of pre-defined resources that you can reference in order to "compose" your app. 

- resources
  - items in the cloud that you want to build instances of. There is documentaion for each and every resource. You reference it by name. 
- providers
  - define the providers (aws) which will download provider specific informaiton for the script and place it into a .terraform file that is local to the working directory
- locals
  - named expressions that can be reference in different part of the script (local variables)
- string interpolation 
  - basically javascript string templates with some extra syntax on top. There are specical functions that help with this. ex: `merge`
- variables
  - a place to define inputs to the script (arguments)
- output
  - can be queried by the user after the resource has been created (return values)
  
### Start up

terraform is just a exe that you download. Need to add the system path (env vars) to where you placed the exe. 


### Work Flow

1. `terraform init` downloads missing dependencies and creates a local folder
2. `terraform apply` does and diff and determines what will happen (execution plan). Create? Update? Delete?
maintains terraform state with a `.tfstate` file which needs to be synced. 


### Notes

- variables.tf vs .tfvars
  - variables.tf is a place where you define variables that will enter the script but they could be empty or have a default value (this is    almost exactly how arguments in a function are described). .tfvars is for actually providing concrete instances of each variable. Each    environment would have its own .tfvars file. 
