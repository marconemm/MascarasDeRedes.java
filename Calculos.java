package marconemendonca.mascarasderedes;

public class Calculos {// Cria a Classe "Hosts":
	byte nZd; // nZd => "Número de Zeros Decimais".
	
	long setHostsPossibles(long hosts_n, String tipoCalc){ //Estabelece o Método "SetHostsPossible(numLong, controller), onde "numLong" é um parâmetro tipo Long e "window" é tipo String".
		long hosts_p = 0;
		switch (tipoCalc){
		case "Indireto": //com cálculo para determinar o nZd.
			if (!(hosts_n == 0)){// se o valor de hosts_n igaul a 0, este método retorna 0.
					nZd = 0;
					// A instrução abaixo, repete o procedimento até encontrar um valor de "zeros decimais" válidos. Ou um "número de Zeros Decimais" acima de 32.
					do {hosts_p = (long)(Math.pow(2,nZd) - 2); //Determina o númeor de HOSTS possíveis.
						if (hosts_p < hosts_n) // Se o número de HOSTS for menor ou igual ao Número de HOSTS possíveis,
							nZd++; //soma mais 1 ao número de ZEROS decimais.
						} while ((hosts_p < hosts_n) && (nZd <= 32)); // determina os limites do cálculo.
					}
			break;
		case "Direto": //sem cálculo para determinar o nZd.
			hosts_p = (long)(Math.pow(2,nZd) - 2); // calcula o "numero de HOSTS possíveis" de acordo com o nZd passado pelo
			break;
		}
			
		return hosts_p;	
	}
	
	public String setMaskBinary(){
		
		String[] G_BIN  = new String[4];
		
		switch (nZd) {
		case 9: G_BIN[0] = "11111111"; G_BIN[1] = "11111111"; G_BIN[2] = "11111110"; G_BIN[3] = "00000000"; break;
		case 17: G_BIN[0] = "11111111"; G_BIN[1] = "11111110"; G_BIN[2] = "00000000"; G_BIN[3] = "00000000"; break;
		case 25: G_BIN[0] = "11111110"; G_BIN[1] = "00000000"; G_BIN[2] = "00000000"; G_BIN[3] = "00000000"; break;
		case 2: G_BIN[0] = "11111111"; G_BIN[1] = "11111111"; G_BIN[2] = "11111111"; G_BIN[3] = "11111100";break;
		case 10: G_BIN[0] = "11111111"; G_BIN[1] = "11111111"; G_BIN[2] = "11111100"; G_BIN[3] = "00000000"; break;
		case 18: G_BIN[0] = "11111111"; G_BIN[1] = "11111100"; G_BIN[2] = "00000000"; G_BIN[3] = "00000000"; break;
		case 26: G_BIN[0] = "11111100"; G_BIN[1] = "00000000"; G_BIN[2] = "00000000"; G_BIN[3] = "00000000"; break;
	    case 3:G_BIN[0] = "11111111";  G_BIN[1] = "11111111"; G_BIN[2] = "11111111"; G_BIN[3] = "11111000"; break;
		case 11: G_BIN[0] = "11111111"; G_BIN[1] = "11111111"; G_BIN[2] = "11111000"; G_BIN[3] = "00000000"; break;
		case 19: G_BIN[0] = "11111111"; G_BIN[1] = "11111000"; G_BIN[2] = "00000000"; G_BIN[3] = "00000000"; break;
		case 27: G_BIN[0] = "11111000"; G_BIN[1] = "00000000"; G_BIN[2] = "00000000"; G_BIN[3] = "00000000"; break;
		case 4: G_BIN[0] = "11111111"; G_BIN[1] = "11111111"; G_BIN[2] = "11111111"; G_BIN[3] = "11110000"; break;
		case 12: G_BIN[0] = "11111111"; G_BIN[1] = "11111111"; G_BIN[2] = "11110000"; G_BIN[3] = "00000000"; break;
		case 20: G_BIN[0] = "11111111"; G_BIN[1] = "11110000"; G_BIN[2] = "00000000"; G_BIN[3] = "00000000"; break;
		case 28: G_BIN[0] = "11110000"; G_BIN[1] = "00000000"; G_BIN[2] = "00000000"; G_BIN[3] = "00000000"; break;
		case 5: G_BIN[0] = "11111111"; G_BIN[1] = "11111111"; G_BIN[2] = "11111111"; G_BIN[3] = "11100000"; break;
		case 13: G_BIN[0] = "11111111"; G_BIN[1] = "11111111"; G_BIN[2] = "11100000"; G_BIN[3] = "00000000"; break;
		case 21: G_BIN[0] = "11111111"; G_BIN[1] = "11100000"; G_BIN[2] = "00000000"; G_BIN[3] = "00000000"; break;
		case 29: G_BIN[0] = "11100000"; G_BIN[1] = "00000000"; G_BIN[2] = "00000000"; G_BIN[3] = "00000000"; break;
	    case 6: G_BIN[0] = "11111111"; G_BIN[1] = "11111111"; G_BIN[2] = "11111111"; G_BIN[3] = "11000000"; break;
		case 14: G_BIN[0] = "11111111"; G_BIN[1] = "11111111"; G_BIN[2] = "11000000"; G_BIN[3] = "00000000";break;
		case 22: G_BIN[0] = "11111111"; G_BIN[1] = "11000000"; G_BIN[2] = "00000000"; G_BIN[3] = "00000000"; break;
		case 30: G_BIN[0] = "11000000"; G_BIN[1] = "00000000"; G_BIN[2] = "00000000"; G_BIN[3] = "00000000"; break;
	    case 7: G_BIN[0] = "11111111"; G_BIN[1] = "11111111"; G_BIN[2] = "11111111"; G_BIN[3] = "10000000"; break;
		case 15: G_BIN[0] = "11111111"; G_BIN[1] = "11111111"; G_BIN[2] = "10000000"; G_BIN[3] = "00000000"; break;
		case 23: G_BIN[0] = "11111111"; G_BIN[1] = "10000000"; G_BIN[2] = "00000000"; G_BIN[3] = "00000000"; break;
		case 31: G_BIN[0] = "10000000"; G_BIN[1] = "00000000"; G_BIN[2] = "00000000"; G_BIN[3] = "00000000"; break;
	    case 8: G_BIN[0] = "11111111"; G_BIN[1] = "11111111"; G_BIN[2] = "11111111"; G_BIN[3] = "00000000"; break;
		case 16: G_BIN[0] = "11111111"; G_BIN[1] = "11111111"; G_BIN[2] = "00000000"; G_BIN[3] = "00000000"; break;
		case 24: G_BIN[0] = "11111111"; G_BIN[1] = "00000000"; G_BIN[2] = "00000000"; G_BIN[3] = "00000000"; break;
		case 32: G_BIN[0] = "00000000"; G_BIN[1] = "00000000"; G_BIN[2] = "00000000"; G_BIN[3] = "00000000"; break;
		case 1: G_BIN[0] = "11111111"; G_BIN[1] = "11111111"; G_BIN[2] = "11111111"; G_BIN[3] = "11111111"; break;
		}
		String maskBin = G_BIN[0]+"."+G_BIN[1]+"."+G_BIN[2]+"."+G_BIN[3];
		return maskBin;
	}
	
	public String setMaskDecimal(){
		
		String[] G_MR  = new String[4];
		
		switch (nZd) {
		case 9: G_MR[0] = "255"; G_MR[1] = "255"; G_MR[2] = "254"; G_MR[3] = "0"; break;
		case 17: G_MR[0] = "255"; G_MR[1] = "254"; G_MR[2] = "0"; G_MR[3] = "0"; break;
		case 25: G_MR[0] = "254"; G_MR[1] = "0"; G_MR[2] = "0"; G_MR[3] = "0";break;
		case 2: G_MR[0] = "255"; G_MR[1] = "255"; G_MR[2] = "255"; G_MR[3] = "252";	break;
		case 10: G_MR[0] = "255"; G_MR[1] = "255"; G_MR[2] = "252"; G_MR[3] = "0"; break;
		case 18:G_MR[0] = "255"; G_MR[1] = "252"; G_MR[2] = "0"; G_MR[3] = "0"; break;
		case 26: G_MR[0] = "252"; G_MR[1] = "0"; G_MR[2] = "0"; G_MR[3] = "0"; break;
	    case 3: G_MR[0] = "255"; G_MR[1] = "255"; G_MR[2] = "255"; G_MR[3] = "248"; break;
		case 11: G_MR[0] = "255"; G_MR[1] = "255"; G_MR[2] = "248"; G_MR[3] = "0"; break;
		case 19: G_MR[0] = "255"; G_MR[1] = "248"; G_MR[2] = "0"; G_MR[3] = "0"; break;
		case 27: G_MR[0] = "248"; G_MR[1] = "0"; G_MR[2] = "0"; G_MR[3] = "0"; break;
		case 4: G_MR[0] = "255"; G_MR[1] = "255"; G_MR[2] = "255"; G_MR[3] = "240"; break;
		case 12: G_MR[0] = "255"; G_MR[1] = "255"; G_MR[2] = "240"; G_MR[3] = "0"; break;
		case 20: G_MR[0] = "255"; G_MR[1] = "240"; G_MR[2] = "0"; G_MR[3] = "0"; break;
		case 28: G_MR[0] = "240"; G_MR[1] = "0"; G_MR[2] = "0"; G_MR[3] = "0"; break;
		case 5: G_MR[0] = "255"; G_MR[1] = "255"; G_MR[2] = "255"; G_MR[3] = "224"; break;
		case 13: G_MR[0] = "255"; G_MR[1] = "255"; G_MR[2] = "224"; G_MR[3] = "0"; break;
		case 21: G_MR[0] = "255"; G_MR[1] = "224"; G_MR[2] = "0"; G_MR[3] = "0";break;
		case 29: G_MR[0] = "224"; G_MR[1] = "0"; G_MR[2] = "0"; G_MR[3] = "0"; break;
	    case 6: G_MR[0] = "255"; G_MR[1] = "255"; G_MR[2] = "255"; G_MR[3] = "192"; break;
		case 14: G_MR[0] = "255"; G_MR[1] = "255"; G_MR[2] = "192"; G_MR[3] = "0"; break;
		case 22:G_MR[0] = "255"; G_MR[1] = "192"; G_MR[2] = "0"; G_MR[3] = "0"; break;
		case 30: G_MR[0] = "192"; G_MR[1] = "0"; G_MR[2] = "0"; G_MR[3] = "0"; break;
	    case 7: G_MR[0] = "255"; G_MR[1] = "255"; G_MR[2] = "255"; G_MR[3] = "128"; break;
		case 15: G_MR[0] = "255"; G_MR[1] = "255"; G_MR[2] = "128"; G_MR[3] = "0"; break;
		case 23: G_MR[0] = "255"; G_MR[1] = "128"; G_MR[2] = "0"; G_MR[3] = "0"; break;
		case 31: G_MR[0] = "128"; G_MR[1] = "0"; G_MR[2] = "0"; G_MR[3] = "0"; break;
	    case 8: G_MR[0] = "255"; G_MR[1] = "255"; G_MR[2] = "255"; G_MR[3] = "0"; break;
		case 16: G_MR[0] = "255"; G_MR[1] = "255"; G_MR[2] = "0"; G_MR[3] = "0"; break;
		case 24: G_MR[0] = "255"; G_MR[1] = "0"; G_MR[2] = "0"; G_MR[3] = "0"; break;
		case 32: G_MR[0] = "0"; G_MR[1] = "0"; G_MR[2] = "0"; G_MR[3] = "0"; break;
		case 1: G_MR[0] = "255"; G_MR[1] = "255"; G_MR[2] = "255"; G_MR[3] = "255"; break;		
		}
		String maskDecimal = G_MR[0]+"."+G_MR[1]+"."+G_MR[2]+"."+G_MR[3];
		return maskDecimal;
	}
	
	byte setCDIR(){
		byte cdir = 0;
		
		switch (nZd) {
		case 9: cdir = 23; break;
		case 17: cdir = 15;	break;
		case 25: cdir = 7; break;
		case 2: cdir = 30; break;
		case 10: cdir = 22; break;
		case 18: cdir = 14; break;
		case 26: cdir = 6; break;
		case 3: cdir = 29; break;
		case 11: cdir = 21; break;
		case 19: cdir = 13; break;
		case 27: cdir = 5; break;
		case 4: cdir = 28; break;
		case 12: cdir = 20; break;
		case 20: cdir = 12; break;
		case 28: cdir = 4; break;
		case 5: cdir = 27; break;
		case 13: cdir = 19; break;
		case 21: cdir = 11; break;
		case 29: cdir = 3; break;
	    case 6: cdir = 26; break;
		case 14: cdir = 18; break;
		case 22: cdir = 10; break;
		case 30: cdir = 2; break;
	    case 7: cdir = 25; break;
		case 15: cdir = 17; break;
		case 23: cdir = 9; break;
		case 31: cdir = 1; break;
	    case 8: cdir = 24; break;
		case 16: cdir = 16; break;
		case 24: cdir = 8; break;
		case 32: cdir = 0; break;		
		}
		
		return cdir;
	}
	
	void getCDIR(byte cdir){
		switch (cdir) {
		case 23: nZd = 9; break;
		case 15: nZd = 17; break;
		case 7: nZd = 25; break;
		case 30: nZd = 2; break;
		case 22: nZd = 10; break;
		case 14: nZd = 18; break;
		case 6: nZd = 26; break;
		case 29: nZd = 3; break;
		case 21: nZd = 11; break;
		case 13: nZd = 19; break;
		case 5: nZd = 27; break;
		case 28: nZd = 4; break;
		case 20: nZd = 12; break;
		case 12: nZd = 20; break;
		case 4: nZd = 28; break;
		case 27: nZd = 5; break;
		case 19: nZd = 13; break;
		case 11: nZd = 21; break;
		case 3: nZd = 29; break;
	    case 26: nZd = 6; break;
		case 18: nZd = 14; break;
		case 10: nZd = 22; break;
		case 2: nZd = 30; break;
	    case 25: nZd = 7; break;
		case 17: nZd = 15; break;
		case 9: nZd = 23; break;
		case 1: nZd = 31; break;
	    case 24: nZd = 8; break;
		case 16: nZd = 16; break;
		case 8: nZd = 24; break;
		case 0: nZd = 32; break;			
		}
	}
	
	void setnZd (byte grupo, short G_MR){
		switch (grupo){
		case 4:
			switch (G_MR){
			case 0: nZd = 8; break;
			case 128: nZd = 7; break;
			case 192: nZd = 6; break;
			case 224: nZd = 5; break;
			case 240: nZd = 4; break;
			case 248: nZd = 3; break;
			case 252: nZd = 2; break;
			}
			break;
		case 3:
			switch (G_MR){
			case 0: nZd = 16; break;
			case 128: nZd = 15; break;
			case 192: nZd = 14; break;
			case 224: nZd = 13; break;
			case 240: nZd = 12; break;
			case 248: nZd = 11; break;
			case 252: nZd = 10; break;
			case 254: nZd = 9; break;
			}
			break;
		case 2:
			switch (G_MR){
			case 0: nZd = 24; break;
			case 128: nZd = 23; break;
			case 192: nZd = 22; break;
			case 224: nZd = 21; break;
			case 240: nZd = 20; break;
			case 248: nZd = 19; break;
			case 252: nZd = 18; break;
			case 254: nZd = 17; break;
			}
			break;
		case 1:
			switch (G_MR){
			case 0: nZd = 32; break;
			case 128: nZd = 31; break;
			case 192: nZd = 30; break;
			case 224: nZd = 29; break;
			case 240: nZd = 28; break;
			case 248: nZd = 27; break;
			case 252: nZd = 26; break;
			case 254: nZd = 25; break;
			}
			break;
		}
	}
}
