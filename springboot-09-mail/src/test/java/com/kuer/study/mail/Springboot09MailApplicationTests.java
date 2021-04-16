package com.kuer.study.mail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot09MailApplicationTests {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Test
    void contextLoads() {
        // 一个简单的邮件
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("Spring mail 测试");
        simpleMailMessage.setText("这是测试信息不用回复");
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo("ajiesw@outlook.com");
        mailSender.send(simpleMailMessage);
    }
    @Test
    void contextLoads1() throws MessagingException {
        // 一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        // 组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "utf-8");
        helper.setSubject("恭喜你通过教资考试第一步");
        String html = "<div id=\"query_result\" style=\"display: block;\">\n" +
                "                <div class=\"c_tits\" style=\"font-size:28px;\"><span id=\"sn\">2018年上半年至2021年上半年中小学教师资格考试（NTCE）</span>笔试成绩</div>\n" +
                "                <table style=\"border-bottom:1px solid #00adef; margin-bottom:30px;\" width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                    <tbody>\n" +
                "                    <tr>\n" +
                "                        <td height=\"32\">\n" +
                "                            <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"etit\">\n" +
                "                                <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td height=\"32\" align=\"left\">姓名：</td>\n" +
                "                                    <td align=\"left\" class=\"fb f16 e16\" style=\"padding-right:30px\" id=\"result_name\">123</td>\n" +
                "                                    <td align=\"left\" class=\"lp100\">证件号码：</td>\n" +
                "                                    <td align=\"left\" class=\"fb f16 e16\" id=\"result_zjhm\">123</td>\n" +
                "                                </tr>\n" +
                "                                </tbody>\n" +
                "                            </table>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                    </tbody>\n" +
                "                </table>\n" +
                "                <div id=\"resultDiv\"><table class=\"odere\" width=\"100%\"><tbody><tr class=\"bg_1\"><th width=\"25%\">科目</th><th width=\"10%\">报告分</th><th width=\"10%\">合格与否</th><th width=\"17%\">准考证号</th><th>考试批次</th><th>有效期限</th><th width=\"10%\">考试省份</th></tr><tr><td align=\"center\" class=\"he_xi\">301-综合素质（中学）</td><td align=\"center\" class=\"he_xi\">74</td><td align=\"center\" class=\"he_xi\">合格</td><td align=\"center\" class=\"he_xi\">432521113015435</td><td align=\"center\" class=\"he_xi\">2021年上半年</td><td align=\"center\" class=\"he_xi\">2023年6月30日</td><td align=\"center\" class=\"he_xi\">湖南省</td></tr><tr><td align=\"center\" class=\"he_xi\">302-教育知识与能力</td><td align=\"center\" class=\"he_xi\">79</td><td align=\"center\" class=\"he_xi\">合格</td><td align=\"center\" class=\"he_xi\">432521113015435</td><td align=\"center\" class=\"he_xi\">2021年上半年</td><td align=\"center\" class=\"he_xi\">2023年6月30日</td><td align=\"center\" class=\"he_xi\">湖南省</td></tr></tbody></table><span class=\"e_bz\"><em>备注：</em>报告分满分120分，70分及以上为合格。</span></div>\n" +
                "                <div class=\"s3 hisbtn\">\n" +
                "                    <input type=\"button\" value=\"返回\" onclick=\"javascript:window.open('http://cjcx.neea.edu.cn/','_self')\" style=\"cursor: pointer\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button onclick=\"javascript:goon();\">继续查询\n" +
                "                </button>\n" +
                "                </div>\n" +
                "            </div>";

        // 附件
        helper.setText(html, true);
        helper.addAttachment("congratulation.jpg", new File("C:\\Users\\kuer\\Desktop\\wallhaven-nmxd5k.jpg"));
        helper.setFrom(from);
        helper.setTo(new String[] {"ajiesw@outlook.com", "2024107115@qq.com"});
        mailSender.send(mimeMessage);
    }

}
