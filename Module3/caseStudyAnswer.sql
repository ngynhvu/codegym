-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select * from nhan_vien 
where (ho_ten like 'H%' or ho_ten like 'T%' or ho_ten like 'K%') and char_length(ho_ten) <=15;

-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select * from khach_hang
where (datediff(curdate(), ngay_sinh)/365 between 18 and 50) and (dia_chi like '%Đà Nẵng' or dia_chi like '%Quảng Trị' );

-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select k.ma_khach_hang, ho_ten, count(h.ma_khach_hang) as 'Số lần đặt phòng'
from khach_hang k join loai_khach l on k.ma_loai_khach = l.ma_loai_khach
join hop_dong h on k.ma_khach_hang = h.ma_khach_hang
where l.ten_loai_khach = 'Diamond'
group by k.ma_khach_hang
order by count(h.ma_khach_hang);

-- 	5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select kh.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.ma_hop_dong, dv.ten_dich_vu, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc,(dv.chi_phi_thue+dvdk.gia*hdct.so_luong) as 'tong_tien'
from khach_hang kh left join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
				   left join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
                   left join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
                   left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
                   left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
group by kh.ma_khach_hang

-- 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
select dv.ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu 
from dich_vu dv join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
				join hop_dong hd on hd.ma_dich_vu = dv.ma_dich_vu
where month(hd.ngay_lam_hop_dong) between 4 and 12
group by dv.ma_dich_vu;

-- 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
select distinct dv.ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu 
from dich_vu dv join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
				join hop_dong hd on hd.ma_dich_vu = dv.ma_dich_vu
where year(hd.ngay_lam_hop_dong) =2020 and 
not exists(select hd.ngay_lam_hop_dong from hop_dong hd join dich_vu dv on dv.ma_dich_vu = hd.ma_dich_vu where year())

-- 8.	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
select distinct ho_ten from khach_hang

-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select month(ngay_lam_hop_dong) as 'thang', count(hd.ma_khach_hang) as 'so_luong_khach_hang'
from hop_dong hd join khach_hang kh on hd.ma_khach_hang = kh.ma_khach_hang
where year(ngay_lam_hop_dong) =2021
group by month(ngay_lam_hop_dong);

-- 10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).
select hd.ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, sum(hdct.so_luong) 'so_luong_dich_vu_di_kem'
from hop_dong hd left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
				 left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
group by hd.ma_hop_dong

-- 11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
select dvdk.ma_dich_vu_di_kem, ten_dich_vu_di_kem
from dich_vu_di_kem dvdk join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
						 join hop_dong hd on hdct.ma_hop_dong = hd.ma_hop_dong
                         join khach_hang kh on hd.ma_khach_hang = kh.ma_khach_hang
                         join loai_khach lk on lk.ma_loai_khach = kh.ma_loai_khach
where kh.dia_chi like '%Vinh' and lk.ten_loai_khach like 'Diamond';

-- 12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), ten_dich_vu, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), tien_dat_coc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.
select hd.ma_hop_dong, nv.ho_ten as 'ho_ten_nhan_vien', kh.ho_ten as 'ho_ten_khach_hang', kh.so_dien_thoai, ten_dich_vu, sum(hdct.so_luong) 'so_luong_dich_vu_di_kem', hd.tien_dat_coc
from hop_dong hd left join nhan_vien nv on nv.ma_nhan_vien = hd.ma_nhan_vien
				  left join khach_hang kh on hd.ma_khach_hang = kh.ma_khach_hang
                  left join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
                  left join hop_dong_chi_tiet hdct on hdct.ma_hop_dong = hd.ma_hop_dong
where year(hd.ngay_lam_hop_dong) like 2020 and month(hd.ngay_lam_hop_dong) between 10 and 12
and year(ngay_lam_hop_dong) not like 2021 and month(ngay_lam_hop_dong) not between 1 and 6
group by kh.ho_ten

-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
select dvdk.ma_dich_vu_di_kem,ten_dich_vu_di_kem, sum(hdct.so_luong) 'so_luong_dich_vu_di_kem' 
from dich_vu_di_kem dvdk join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
group by dvdk.ma_dich_vu_di_kem
having sum(hdct.so_luong) = (select MAX(a.so_luong_dich_vu_di_kem) from (
select dvdk.ma_dich_vu_di_kem,ten_dich_vu_di_kem, sum(hdct.so_luong) 'so_luong_dich_vu_di_kem' 
from dich_vu_di_kem dvdk join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
group by dvdk.ma_dich_vu_di_kem ) a)


-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem).
select hd.ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, count(hdct.ma_dich_vu_di_kem) 'so_lan_su_dung'
from hop_dong hd join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
				 join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
                 join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
                 join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem=hdct.ma_dich_vu_di_kem
group by ten_dich_vu_di_kem
having count(hdct.ma_dich_vu_di_kem) = 1;

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.
select nv.ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi
from nhan_vien nv join bo_phan bp on nv.ma_bo_phan = bp.ma_bo_phan
				  join hop_dong hd on nv.ma_nhan_vien = hd.ma_nhan_vien
                  join trinh_do td on nv.ma_trinh_do = td.ma_trinh_do
group by nv.ma_nhan_vien
having count(ma_hop_dong)>=3;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
select nv.ma_nhan_vien, ho_ten from nhan_vien nv
left join hop_dong hd on nv.ma_nhan_vien = hd.ma_nhan_vien
where hd.ma_nhan_vien is null

-- 17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.
update khach_hang
set khach_hang.ma_loai_khach = 1
where khach_hang.ma_khach_hang in (select * from(select kh.ma_khach_hang
from khach_hang kh join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
				   join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
                   join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
                   join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
                   join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
where lk.ten_loai_khach like 'Platinium' and (dv.chi_phi_thue+dvdk.gia*hdct.so_luong) >10000000 and year(hd.ngay_lam_hop_dong) = 2021) tabla
)

-- 18.	Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
delete from hop_dong
where ma_khach_hang in (select ma_khach_hang from ( select ma_khach_hang from hop_dong where year(ngay_lam_hop_dong)<2021) temp)

-- 19.	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi
update dich_vu_di_kem
set gia = gia*2
where ma_dich_vu_di_kem in (select ma_dich_vu_di_kem from (select dvdk.ma_dich_vu_di_kem
from hop_dong_chi_tiet hdct 
join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
join hop_dong hd on hdct.ma_hop_dong = hd.ma_hop_dong
where year(hd.ngay_lam_hop_dong) = 2020
group by dvdk.ma_dich_vu_di_kem
having sum(hdct.so_luong)>10) as tab)

-- 20.	Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
select ma_nhan_vien, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi from nhan_vien
union all
select ma_khach_hang, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi from khach_hang

-- 21.	Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” và đã từng lập hợp đồng cho một hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “12/12/2019”.
create view v_nhan_vien as
select * from nhan_vien
where dia_chi like '%Hải Châu' and ma_nhan_vien in(select ma_nhan_vien from hop_dong where ngay_lam_hop_dong = '2019-12-12%' group by ma_nhan_vien having count(ma_nhan_vien)>0)

-- 22.	Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất cả các nhân viên được nhìn thấy bởi khung nhìn này.
update v_nhan_vien
set dia_chi = 'Liên Chiểu'

-- 23.	Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của một khách hàng nào đó với ma_khach_hang được truyền vào như là 1 tham số của sp_xoa_khach_hang.
DROP PROCEDURE IF EXISTS `sp_xoa_khach_hang`
DELIMITER //
create procedure sp_xoa_khach_hang(in id int)
begin
	delete from khach_hang where ma_khach_hang = id;
end //
DELIMITER ;

call sp_khach_hang(10);

-- 24.	Tạo Stored Procedure sp_them_moi_hop_dong dùng để thêm mới vào bảng hop_dong với yêu cầu sp_them_moi_hop_dong phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.
