package regmoraes.rplmanager.database.databasemanager;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by regmoraes on 11/06/15.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

        private static String DB_PATH;
        private static String DB_NAME = "rplmgr.db";
        private SQLiteDatabase bdQuery;
        private final Context bdContext;
        private static DataBaseHelper instancia = null;


        public DataBaseHelper(Context context) {

            super(context, DB_NAME, null, 1);
            this.bdContext = context;
            this.DB_PATH = context.getDatabasePath(DataBaseHelper.DB_NAME).toString();
        }

        public static DataBaseHelper getInstancia(Context context) {

            if (instancia == null) {

                instancia = new DataBaseHelper(context);
            }
            return instancia;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // TODO Auto-generated method stub

        }

        private void criarBancoDeDados() throws IOException {

            boolean dbExist = checarBancoDeDados();

            if (!dbExist) {
                this.getReadableDatabase();

                try {
                    this.copiarBancoDeDados();
                } catch (IOException e) {
                    throw new Error("Erro ao copiar o Banco de Dados!");
                }
            }
        }

        private void copiarBancoDeDados() throws IOException {

            InputStream myInput = bdContext.getAssets().open(DB_NAME);
            String outFileName = DB_PATH;
            OutputStream myOutput = new FileOutputStream(outFileName);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }

            myOutput.flush();
            myOutput.close();
            myInput.close();

        }

        private boolean checarBancoDeDados() {

            File dbFile = bdContext.getDatabasePath(DB_NAME);
            return dbFile.exists();
            /*SQLiteDatabase checkDB = null;

            try {
                String myPath = DB_PATH;
                checkDB = SQLiteDatabase.openDatabase(myPath, null,
                        SQLiteDatabase.OPEN_READONLY);
            } catch (SQLiteException e) {
            }

            if (checkDB != null) {
                checkDB.close();
            }

            return checkDB != null ? true : false;
            */
        }

        private void abrirBancoDeDados() throws SQLException {

            String myPath = DB_PATH;
            bdQuery = SQLiteDatabase.openDatabase(myPath, null,
                    SQLiteDatabase.OPEN_READWRITE);
        }

        public void setBancoDados() {

            try {
                criarBancoDeDados();
                abrirBancoDeDados();

            } catch (IOException e) {
                e.printStackTrace();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }
