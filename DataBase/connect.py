import psycopg2

try:
    conn = psycopg2.connect("dbname='indicadoresdb' user='rest' password='123'")
    print("connected to the database.")
except:
    print("unable to connect ot the database")
