#coding:utf-8
"""
cursor.rowcount
cursor.lastrowid
"""
import mysql.connector as MC

try:
    conn = MC.connect(host = 'localhost', database = 'datatest', user = 'root', password = '')
    cursor = conn.cursor()

    req = 'INSERT INTO ninjatable(id_ninja, ninja_firstname, ninja_lastname) VALUES(%s, %s, %s)'
    infos = (cursor.lastrowid, 'Shikamaru', 'Nara')

    cursor.execute(req, infos)
    conn.commit()

    req = 'SELECT * FROM ninjatable'
    cursor.execute(req)

    ninjalist = cursor.fetchall()

    for ninja in ninjalist:
        print('Prénom : {}'.format(ninja[1]))

except MC.Error as err:
    print(err)
finally:
    if(conn.is_connected()):
        cursor.close()
        conn.close()