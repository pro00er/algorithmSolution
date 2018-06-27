import org.junit.Test;
import static org.junit.Assert.*;

public class PreficSums_GenomicRangeQuery {
	@Test
	public void solutionTest() {
		assertArrayEquals(new int[]{2,4,1}, solution("CAGCCTA",new int[]{2,5,0},new int[]{4,5,6}));
	}
	
	@Test
	public void findAlphaWeightTest() {
		assertEquals(1, findAlphaWeight('A'));
		assertEquals(2, findAlphaWeight('C'));
		assertEquals(3, findAlphaWeight('G'));
		assertEquals(4, findAlphaWeight('T'));
	}

	private static int[] solution(String s, int[] P, int[] Q) {
		char[] alphas = s.toCharArray();
		int[] weights = new int[alphas.length];
		int[] minWeghts = new int[P.length];
		
		int idx = 0;
		for(char alpha:alphas) {
			weights[idx++] = findAlphaWeight(alpha);
		}

		for(idx=0;idx<P.length;idx++) {
			int minWeight = weights[Q[idx]];
			for(int searchingIdx=P[idx], endIdx=Q[idx];searchingIdx < endIdx;searchingIdx++) {
				if( minWeight > weights[searchingIdx])
					minWeight = weights[searchingIdx];
			}
			
			minWeghts[idx] = minWeight;
		}
		
		return minWeghts;
	}

	private static int findAlphaWeight(char alpha) {
		switch (alpha) {
			case 'C' : return 2;
			case 'A' : return 1;
			case 'G' : return 3;
		}
		
		return 4;
	}
}