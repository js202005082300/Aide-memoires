<?php

class Database
{
    private $_conn;
    private static $_instance = null;
    
    private static $DB_DSN = 'mysql:host=localhost;dbname=formationvideo_db';
    private static $DB_USER = 'root';
    private static $DB_PASS = '';

    private function __construct()
    {
        try
        {
            $options =
            [
                PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
                PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
                PDO::ATTR_EMULATE_PREPARES => false
            ];

            $this->_conn = new PDO(self::$DB_DSN, self::$DB_USER, self::$DB_PASS, $options);
        }
        catch(PDOException $e)
        {
            die("ERREUR : " . $e->getMessage());
        }
    }

    public static function getInstance()
    {
        if(is_null(self::$_instance))
            self::$_instance = new Database();

        return self::$_instance;
    }

    public function request($sql, $fields)
    {
        $req = $this->_conn->prepare($sql);
        $req->execute($fields);

        return $req->fetch(PDO::FETCH_ASSOC);
    }
}

?>