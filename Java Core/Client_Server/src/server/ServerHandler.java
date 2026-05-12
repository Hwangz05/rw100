package server;

import dao.SinhVienDAO;
import model.SinhVien;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ServerHandler implements Runnable {
    private Socket socket;

    public ServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            SinhVienDAO dao = new SinhVienDAO();

            ObjectInputStream in =
                    new ObjectInputStream(socket.getInputStream());

            ObjectOutputStream out =
                    new ObjectOutputStream(socket.getOutputStream());

            while (true) {

                Request req = (Request) in.readObject();

                switch (req.getAction()) {

                    case "INSERT":

                        boolean insert = dao.insert(req.getSinhVien());

                        out.writeObject(new Response(insert,
                                insert ? "Thêm thành công"
                                        : "Thêm thất bại"));

                        break;

                    case "UPDATE":

                        boolean update = dao.update(req.getSinhVien());

                        out.writeObject(new Response(update,
                                update ? "Cập nhật thành công"
                                        : "Cập nhật thất bại"));

                        break;

                    case "DELETE":

                        boolean delete = dao.delete(req.getMaSV());

                        out.writeObject(new Response(delete,
                                delete ? "Xóa thành công"
                                        : "Xóa thất bại"));

                        break;

                    case "FIND":

                        SinhVien sv = dao.findById(req.getMaSV());

                        if (sv != null) {
                            out.writeObject(new Response(true,
                                    "Tìm thấy", sv));
                        } else {
                            out.writeObject(new Response(false,
                                    "Không tìm thấy"));
                        }

                        break;

                    case "LIST":

                        List<SinhVien> list = dao.getAll();

                        out.writeObject(new Response(true,
                                "Lấy danh sách thành công", list));

                        break;
                }

                out.flush();
            }

        } catch (Exception e) {
            System.out.println("Client disconnected");
        }
    }
}