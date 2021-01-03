## Deployment Instructions

### Run this one time setup
git clone https://github.com/riyas90cse/oompa-loompa-devops.git

cd oompa-loompa-devops

sudo chmod 755 docker_setup.sh

### Run this to build docker base image under (~/oompa-loompa-devops)
./docker_setup.sh

### Run this to up the services under (~/oompa-loompa-devops)
docker-compose build

docker-compose up -d

### Run this to stop the services under (~/oompa-loompa-devops)
docker-compose stop

### Run this to stop and remove the services under (~/oompa-loompa-devops)
docker-compose down -v
