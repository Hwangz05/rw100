package client;

import server.Request;
import server.Response;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientConnection {

    private Socket socket;

    private ObjectOutputStream out;
    private ObjectInputStream in;

    // ================= CONNECT =================
    public boolean connect() {

        try {

            // Kết nối tới server
            socket = new Socket("localhost", 9999);

            // Khởi tạo stream gửi dữ liệu
            out = new ObjectOutputStream(socket.getOutputStream());

            // Khởi tạo stream nhận dữ liệu
            in = new ObjectInputStream(socket.getInputStream());

            System.out.println("Kết nối server thành công!");

            return true;

        } catch (Exception e) {

            System.out.println("Không thể kết nối server!");

            e.printStackTrace();
        }

        return false;
    }

    // ================= SEND REQUEST =================
    public Response sendRequest(Request request) {

        try {

            // Gửi request lên server
            out.writeObject(request);

            // Đẩy dữ liệu đi
            out.flush();

            // Nhận phản hồi từ server
            Response response = (Response) in.readObject();

            return response;

        } catch (Exception e) {

            System.out.println("Lỗi gửi dữ liệu!");

            e.printStackTrace();
        }

        return null;
    }

    // ================= CLOSE CONNECTION =================
    public void closeConnection() {

        try {

            if (in != null) {
                in.close();
            }

            if (out != null) {
                out.close();
            }

            if (socket != null) {
                socket.close();
            }

            System.out.println("Đã đóng kết nối!");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}