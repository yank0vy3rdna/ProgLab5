class Domain implements Domainable{
	Storable storage;
	Domain(Storable storage){
		this.storage = storage;
	}
	public String execute(String command, Executable ex, UI ui, StoredTypeReader reader, Workerable worker){
		return ex.exec(command, storage, ui, reader, worker);
	}
	public void init(String filename, Workerable worker, Class cls) {
		storage.init(filename, worker,cls);
	}

	public void save(String filename, Workerable worker) {
		storage.save(filename,worker);
	}

}