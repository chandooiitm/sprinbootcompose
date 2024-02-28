terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 3.0"
    }
  }
}

provider "aws" {
  region = "us-easet-1a"
}
resource "aws_instance" "terraform-instance" {
  ami           = "XXXXXXXX"
  instance_type = "t2.micro"
}