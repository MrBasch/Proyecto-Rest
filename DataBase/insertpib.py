import psycopg2
import csv

try:
    conn = psycopg2.connect("dbname='indicadoresdb' user='rest' password='123'")
    conn.autocommit = True
    print("connected to the database.")
except:
    print("unable to connect ot the database")

cur = conn.cursor()
insert_query ="INSERT INTO fact(fk_periodo,fk_pais,fk_indicador,valor) VALUES(%s,%s,%s,%s)"

try:
    with open('fact_pib.csv', encoding='utf-8') as f:
        reader = csv.reader(f, delimiter = ';')
        First = True
        for row in reader:
            if(not First):
                record = (row[0],row[1],row[2],row[3])
                cur.execute(insert_query,record)
                conn.commit()
            else:
                First = False
    print("OK")    
except (Exception, psycopg2.Error) as error :
    if(conn):
        print(error)
    
conn.close()