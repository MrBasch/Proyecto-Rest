import psycopg2

try:
    conn = psycopg2.connect("dbname='indicadoresdb' user='rest' password='123'")
    conn.autocommit = True
    print("connected to the database.")
except:
    print("unable to connect ot the database")

cur = conn.cursor()

years =[2005,2006,2007,2008,2009,2010,2011,2012,2013,2014,2015,2016,2017,2018,2019,2020]

try:
    for Y in years:
        cur.execute("INSERT INTO periodo(año) VALUES(%s)"%Y)
        conn.commit()
    print("OK")
except (Exception, psycopg2.Error) as error :
    if(conn):
        print(error)

conn.close()