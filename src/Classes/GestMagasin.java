package Classes;

public class GestMagasin {
	    private static Magasin magasin;

	    public static Magasin getMagasin() {
	        if (magasin == null) {
	            magasin = new Magasin("Mon Magasin", "123 Rue de la Ville");
	        }
	        return magasin;
	    }
	}

