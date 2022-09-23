FROM mariadb
ENV MYSQL_ROOT_PASSWORD 11111111
ENV MYSQL_DATABASE mydb
COPY ./mysql_data/mysql /var/lib/mysql
EXPOSE 3306
ENTRYPOINT ["mysqld", "--user=root"]