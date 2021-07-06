#coding:utf-8
import sqlite3

try:
    connection = sqlite3.connect("base.db")
    cursor = connection.cursor()
    
    user = ("Toto",)
    req = cursor.execute('SELECT * FROM tt_users WHERE user_name = ?', user)

    for row in req.fetchall():
        print(row[1])

except Exception as e:
    print("[ERREUR]", e)
    connection.rollback()

finally:
    connection.close()