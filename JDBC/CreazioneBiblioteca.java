import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreazioneBiblioteca {
    public static void Inizialize ()
    {
        CreateDB(ConnessioneDB.CreateConnection("jdbc:mysql://localhost:3306/", "root", "root"));
        CreateTables(ConnessioneDB.CreateConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "root"));
    }

    private static void CreateDB(Connection connection) {
        if (connection == null)
            return;

        try {
            Statement st = connection.createStatement();
            st.execute("CREATE DATABASE IF NOT EXISTS biblioteca");

        } catch (SQLException e) {
            System.out.println("ERRORE " + e.getMessage());
        }
    }

    private static void CreateTables(Connection connection) {
        String query;

        query = "CREATE TABLE IF NOT EXISTS autori(nome varchar(50) primary key, anno_nascita int not null, anno_morte int default 0 not null, nazione varchar(50) not null);";
        ConnessioneDB.ExecuteQuery(query, connection);

        query = "CREATE TABLE IF NOT EXISTS libri(titolo varchar(50), autore varchar(50), anno_pb int not null, primary key(titolo, autore), foreign key (autore) references autori (nome));";
        ConnessioneDB.ExecuteQuery(query, connection);

        System.out.println("Inizializzazione Terminata!");
    }
}