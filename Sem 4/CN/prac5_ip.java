import java.util.Scanner;

public class prac5_ip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the ip address : ");
        String ip = sc.nextLine();
        String[] ipl = ip.split("\\.");
        String ipclass = "";
        String subnet_mask = "";
        String subnet_add = "";
        if (ipl.length == 4) {
            int firstOctet = Integer.parseInt(ipl[0]);
            if (firstOctet >= 0 && firstOctet <= 127) {
                ipclass = "A";
                subnet_mask = "255.0.0.0";
            } else if (firstOctet >= 128 && firstOctet <= 191) {
                ipclass = "B";
                subnet_mask = "255.255.0.0";
            } else if (firstOctet >= 192 && firstOctet <= 223) {
                ipclass = "C";
                subnet_mask = "255.255.255.0";
            } else if (firstOctet >= 224 && firstOctet <= 239) {
                ipclass = "D";
                subnet_mask = "Multicast";
            } else if (firstOctet >= 240 && firstOctet <= 255) {
                ipclass = "E";
                subnet_mask = "Reserved";
            }
            subnet_add = logand(ipl, subnet_mask);
        } else {
            System.out.println("Enter a correct ip address");
            System.exit(0);
        }
        System.out.println("class : " + ipclass + ", subnet_mask: " + subnet_mask);
        System.out.println("Subnet address : ");
        System.out.println(subnet_add);
    }

    public static String logand(String[] ipl, String mask) {
        String subnet_add = "";
        String[] maskArr = mask.split("\\.");
        for (int i = 0; i < ipl.length; i++) {
            subnet_add += (Integer.parseInt(ipl[i]) & Integer.parseInt(maskArr[i])) + ".";
        }
        subnet_add = subnet_add.substring(0, subnet_add.length() - 1);
        return subnet_add;
    }
}
