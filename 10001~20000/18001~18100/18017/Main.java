import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static final BigDecimal cSq = new BigDecimal("299792458").multiply(new BigDecimal("299792458"));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		String a = st.nextToken();
		String b = st.nextToken();

		BigDecimal bunja = cSq.multiply(new BigDecimal(a).add(new BigDecimal(b)));
		BigDecimal bunmo = cSq.add(new BigDecimal(a).multiply(new BigDecimal(b)));

		BigDecimal result = bunja.divide(bunmo, 15, BigDecimal.ROUND_CEILING);

		bw.write(result.toString());

		bw.flush();
	}
}