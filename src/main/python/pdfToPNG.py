from wand.image import Image

def pdfPng(name):
	with Image(filename=name) as original:
	    with original.convert('png') as converted:
	        converted.save(filename= name +'.png')
	        return converted


pdfPng("./jesu-joy-of-mans-desiring-piano-solo.pdf")
