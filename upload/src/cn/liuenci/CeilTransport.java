package cn.liuenci;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@WebServlet("/load")
@MultipartConfig
public class CeilTransport extends HttpServlet {
	String path = "";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//�����ַ�����
		req.setCharacterEncoding("utf-8");
		//����ҳ�����
		resp.setContentType("text/html;charset=utf-8");
		//�����������
		PrintWriter out = resp.getWriter();
		//��ȡ����ύ���ļ�
		Part p = req.getPart("ul");
		//��ȡ·��
		path = req.getServletContext().getRealPath("");
		//���
		out.println("�ļ�·��:"+path+"<br/>");
		out.println("�����nameֵ:"+p.getName()+"<br/>");
		out.println("�ļ���С:"+p.getSize()+"<br/>");
		out.println("�ļ���:"+p.getSubmittedFileName()+"<br/>");
		//������·��
		//��������ļ���
		String fileName = UUID.randomUUID().toString();
		//��ȡ������
		String fileProjectName = p.getSubmittedFileName();
		//��ȡ��׺��
		String endName = fileProjectName.substring(fileProjectName.lastIndexOf("."));
		String savePath = this.savePath()+File.separator+fileName+endName;
		out.println(savePath);
		//�����ļ�
		p.write(savePath);
		//��ʾͼƬ
		String showPath = savePath.replace(path, "");
		out.println("<img src='"+showPath+"'>");
	}
	/*
	 * ����Ŀ¼
	 */
	public String savePath() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		File file = new File(path,sdf.format(new Date()));
		if(!file.exists()) {
			file.mkdirs();
		}
		return file.getAbsolutePath();
	}
	public static void main(String[] args) {

	}

}
