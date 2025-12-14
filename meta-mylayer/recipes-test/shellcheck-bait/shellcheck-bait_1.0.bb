SUMMARY = "ShellCheck demo recipe with intentional issues"
LICENSE = "MIT"
SRC_URI = "file://install.sh"

S = "${UNPACKDIR}"

do_install() {
    sh install.sh ${D}
}
