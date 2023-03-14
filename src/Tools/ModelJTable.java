package Tools;

import Entities.Acteur;
import Entities.Cinema;
import Entities.Film;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModelJTable extends AbstractTableModel
{
    private String[] columns;
    private Object[][] rows;

    @Override
    public int getRowCount() {
        return rows.length;
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    public void loadCinema(ArrayList<Cinema> lesCinema)
    {
        columns = new String[]{"Numéro", "Nom"};
        rows = new Object[lesCinema.size()][2];
        int i = 0;

        for (Cinema cin : lesCinema){
            rows [i][0] = cin.getIdCinema();
            rows [i][1] = cin.getNomCinema();
            i++;
        }
        fireTableChanged(null);
    }

    public void loadFilm(ArrayList<Film> lesFilms)
    {
        columns = new String[]{"Numéro", "Nom","Nb votes", "Total vote"};
        rows = new Object[lesFilms.size()][4];
        int i = 0;

        for (Film flm : lesFilms){
            rows [i][0] = flm.getIdFilm();
            rows [i][1] = flm.getNomFilm();
            rows [i][2] = flm.getNbVotes();
            rows [i][3] = flm.getTotalVotes();
            i++;
        }
        fireTableChanged(null);
    }

    public void loadActeurs(ArrayList<Acteur> lesActeurs)
    {
        columns = new String[]{"Numéro", "Nom","Notes"};
        rows = new Object[lesActeurs.size()][3];
        int i = 0;

        for (Acteur act : lesActeurs){
            rows [i][0] = act.getIdActeur();
            rows [i][1] = act.getNomActeur();
            rows [i][2] = act.getNoteActeur();
            i++;
        }
        fireTableChanged(null);
    }

}
