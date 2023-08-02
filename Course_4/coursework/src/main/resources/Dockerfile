#Start docker container
FROM Ubuntu
RUN docker -d --hostname morozov --name sky-pro -p 5432:5432 -e POSTGRES_USER=morozov -e POSTGRES_PASSWORD=root -e POSTGRES_DB=sky-pro -v /data:/c/postgres_data --restart=unless-stopped postgres:14.5;