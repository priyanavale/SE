#include<iostream>
#include<fstream>
#include<string.h>
using namespace std;
class student
  {
	typedef struct stud
	{
		int roll;
		char name[10];
		char div;
		char add[10];
	}stud;
	stud rec;
	public:
	  void create();
	  void display();
	  int search();
	  void Delete();
  };
void student::create()
  {
	char ans;
	ofstream fout;
	fout.open("stud.dat",ios::out|ios::binary);
	do
	  {
		cout<<"\nEnter Roll No of Student    : ";
		cin>>rec.roll;
		cout<<"\nEnter a Name of Student     : ";
		cin>>rec.name;
		cout<<"\nEnter a Division of Student : ";
		cin>>rec.div;
		cout<<"\nEnter a Address of Student  : ";
		cin>>rec.add;
		fout.write((char *)&rec,sizeof(stud))<<flush;
		cout<<"\nDo You Want to Add More Records: ";
		cin>>ans;
	  }while(ans=='y'||ans=='Y');
	fout.close();
  }
void student::display()
  {
	ifstream fin;
	fin.open("stud.dat",ios::in|ios::binary);
	fin.seekg(0,ios::beg);
	cout<<"\nThe Content of File are:";
	cout<<"\nRoll\tName\tDiv\tAddress";
	while(fin.read((char *)&rec,sizeof(stud)))
	  {
		if(rec.roll!=-1)
       		  cout<<"\n"<<rec.roll<<"\t"<<rec.name<<"\t"<<rec.div<<"\t"<<rec.add;
	  }
	fin.close();
  }
int student::search()
  {
	int r,i=0;
	ifstream fin;
	fin.open("stud.dat",ios::in|ios::binary);
	fin.seekg(0,ios::beg);
	cout<<"\nEnter a Roll No: ";
	cin>>r;
	while(fin.read((char *)&rec,sizeof(stud)))
	  {
		if(rec.roll==r)
		  {
			cout<<"\nRecord Found...";
			cout<<"\nRoll\tName\tDiv\tAddress";
			cout<<"\n"<<rec.roll<<"\t"<<rec.name<<"\t"<<rec.div<<"\t"<<rec.add;
			return i;
		  }
		i++;
	  }
	fin.close();
	return 0;
  }
void student::Delete()
  {
	int pos;
	pos=search();
	fstream f;
	f.open("stud.dat",ios::in|ios::out|ios::binary);
	f.seekg(0,ios::beg);
	if(pos==0)
	  {
		cout<<"\nRecord Not Found";
		return;
	  }
	int offset=pos*sizeof(stud);
	f.seekp(offset);
	rec.roll=-1;
	strcpy(rec.name,"NULL");
	rec.div='N';
	strcpy(rec.add,"NULL");
	f.write((char *)&rec,sizeof(stud));
	f.seekg(0);
	f.close();
	cout<<"\nRecord Deleted";
  }
	
int main()
  {
	student obj;
	int ch,key;
	char ans;
	do
	  {
		cout<<"\n***** Student Information *****";
		cout<<"\n. Create\n2. Display\n3. Delete\n4. Search\n5. Exit";
		cout<<"\n..... Enter Your Choice: ";
		cin>>ch;
		switch(ch)
		  {
			case 1: obj.create();
				break;
			case 2:	obj.display();
				break;
			case 3: obj.Delete();
				break;
			case 4: key=obj.search();
				if(key==0)
				  cout<<"\n\tRecord Not Found...\n";
				break;
			case 5:
				break;
		  }
		cout<<"\n\t..... Do You Want to Continue in Main Menu: ";
		cin>>ans;
	  }while(ans=='y'||ans=='Y');
return 1;
  }
