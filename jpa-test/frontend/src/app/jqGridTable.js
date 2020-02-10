import React from 'react'
import $ from 'jquery'
import {findDOMNode} from 'react-dom'
import '../resources/js/jqgrid/jquery.jqgrid.src.js'
import PropTypes from 'prop-types'

class Table extends React.Component{
	tableElement = null;

	componentDidMount(){
		this.tableElement = findDOMNode(this.refs.tableObj);
		$(this.tableElement).jqGrid({
			colModel: this.props.colModel,
			data: this.props.data
		});
	}
	componentDidUpdate(){
		$(this.tableElement).jqGrid('clearGridData');
		$(this.tableElement).jqGrid('setGridParam', {
			data: this.props.data
		}).trigger('reloadGrid');
	}

	render(){
		return(
				<table ref="tableObj"></table>
		)
	}
}
Table.defaultProps = {
	data: []
}
// Table.propTypes = {
// 	colModel: PropTypes.array.isRequired
// }
export default Table;