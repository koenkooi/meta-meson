FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
	file://gxtvbb_vh264_mc \
	file://gxb_vh264_mc \
	file://vh264_mc \
	file://vh265_mc \
	file://vh265_mc_mmu \
	file://vmpeg12_mc \
	file://vmpeg4_mc_5 \
	file://h263_mc \
"

do_install_append_meson-gxbb () {
	install -Dm 0644 ${WORKDIR}/gxb_vh264_mc ${D}/lib/firmware/meson/gxl/gxtvbb_vh264_mc
}

do_install_append_meson-gxl () {
	install -Dm 0644 ${WORKDIR}/gxtvbb_vh264_mc ${D}/lib/firmware/meson/gxl/vh264_mc
}

do_install_append () {
	install -Dm 0644 ${WORKDIR}/vh265_mc ${D}/lib/firmware/meson/gxl/vh265_mc
	install -Dm 0644 ${WORKDIR}/vh265_mc_mmu ${D}/lib/firmware/meson/gxl/vh265_mc_mmu
	install -Dm 0644 ${WORKDIR}/vmpeg12_mc ${D}/lib/firmware/meson/gxl/vmpeg12_mc
	install -Dm 0644 ${WORKDIR}/vmpeg4_mc_5 ${D}/lib/firmware/meson/gxl/vmpeg4_mc_5
	install -Dm 0644 ${WORKDIR}/vmpeg4_mc_5 ${D}/lib/firmware/meson/gxl/vmpeg4_mc_5
	install -Dm 0644 ${WORKDIR}/h263_mc ${D}/lib/firmware/meson/gxl/h263_mc
}
