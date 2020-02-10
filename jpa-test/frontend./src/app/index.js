import React from 'react'
import ReactDOM from 'react-dom'
import axios from 'axios'
import Table from './jqGridTable'

class App extends React.Component{
	constructor(props){
		super(props);
		this.state = {columnData: []};
	}
	
	componentDidMount(){

		axios('/findTicket', {
			method: 'GET'
		})
		.then(res => {
			this.setState({columnData: res.data});
		})
	}

	render(){
		const tableInfo = [{name:'id',label:'ID', width:60},
	 				{name:'amount',label:'AMOUNT', width:90},
					 {name:'category',label:'CATEGORY', width:100}];

		return(
			<>
				<Table colModel={tableInfo} data = {this.state.columnData}/>
				{/* <Table colModel={tableInfo2} />
				<Table colModel={tableInfo2} data = {[{id: "200", amount: '5000', category: "travel"}]}/> */}
			</>
		)
	}
}

ReactDOM.render(<App />, document.getElementById('react'));