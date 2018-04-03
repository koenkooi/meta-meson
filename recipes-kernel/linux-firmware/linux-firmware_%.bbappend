FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
	file://gxtvbb_vh264_mc \
"

do_install_append () {
	install -Dm 0644 ${WORKDIR}/gxtvbb_vh264_mc ${D}/lib/firmware/meson/gxl/gxtvbb_vh264_mc
}
